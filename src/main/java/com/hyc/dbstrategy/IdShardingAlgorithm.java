package com.hyc.dbstrategy;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashSet;

public class IdShardingAlgorithm implements PreciseShardingAlgorithm<Long>, RangeShardingAlgorithm<Long> {

    /**
     * Using Wang/Jenkins Hash
     *
     * @param key
     * @return hash value
     */
    protected int hash(int key) {
        key = (~key) + (key << 21); // key = (key << 21) - key - 1;
        key = key ^ (key >> 24);
        key = (key + (key << 3)) + (key << 8); // key * 265
        key = key ^ (key >> 14);
        key = (key + (key << 2)) + (key << 4); // key * 21
        key = key ^ (key >> 28);
        key = key + (key << 31);
        return key;
    }

    public Integer calculate(String columnValue) {
        int count = 16;
//        columnValue = columnValue.replace("\'", " ");
//        columnValue = columnValue.trim();
        BigInteger bigNum = new BigInteger(hash(columnValue.hashCode()) + "").abs();
        // if count==2^n, then m%count == m&(count-1)
        return bigNum.intValue() & (count - 1);
        //return (bigNum.mod(BigInteger.valueOf(count))).intValue();
    }

    /**
     * Sharding.
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding result for data source or table's name
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // String databaseName = availableTargetNames.stream().findFirst().get();
        // String columnValue = shardingValue.getValue() + "";
        // int dbCount = calculate(columnValue);
        // for (String dbName : availableTargetNames) {
        //     if (dbName.endsWith(dbCount + 1 + "")) {
        //         databaseName = dbName;
        //     }
        // }
        // return databaseName;
        String table = availableTargetNames.stream().findFirst().get();

        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(idToTableSuffix(shardingValue.getValue()))) {
                table = tableName;
            }
        }

        return table;
    }

    /**
     * Sharding.
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding results for data sources or tables's names
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        Collection<String> dbs = new LinkedHashSet<>(availableTargetNames.size());

        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String dbName : availableTargetNames) {
                if (dbName.endsWith(idToTableSuffix(i))) {
                    dbs.add(dbName);
                }
            }
        }

        return dbs;
    }

    /**
     * 字段与分表的映射关系
     *
     * @param id
     * @return 表后缀（201906、201907等）
     */
    private String idToTableSuffix(Long id) {
        return String.valueOf(id % 2);
    }
}