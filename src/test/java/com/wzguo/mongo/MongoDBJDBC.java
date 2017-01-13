package com.wzguo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Intellij IDEA 2016.3
 *
 * @描述
 * @作者 wzguo
 * @版本 1.0.0
 * @日期 01月12日, 2017
 */
public class MongoDBJDBC {

    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 12345);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("col");
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
