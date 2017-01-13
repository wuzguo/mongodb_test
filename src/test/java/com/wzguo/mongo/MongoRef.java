package com.wzguo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;
import org.bson.Document;

/**
 * Intellij IDEA 2016.3
 *
 * @描述
 * @作者 wzguo
 * @版本 1.0.0
 * @日期 01月12日, 2017
 */
public class MongoRef {

    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 12345);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("imooc");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("col");

            FindIterable<Document> documents = documentMongoCollection.find(Filters.eq("name", "Tom Benzamin"));

            MongoCursor<Document> documentMongoCursor = documents.iterator();

            while (documentMongoCursor.hasNext()) {
                Document document = documentMongoCursor.next();
                System.out.println("document: " + document);


                System.out.println("document.$db: " + JSON.serialize(document.get("document")));

                MongoDatabase mongoDatabase1 =  mongoClient.getDatabase(document.getString("$db"));
                System.out.println("Connect to database successfully");

                MongoCollection<Document> documentMongoCollection1 = mongoDatabase1.getCollection(document.getString("$ref"));

                FindIterable<Document> documents1 = documentMongoCollection1.find(Filters.eq("_id", document.getString("$id")));

                MongoCursor<Document> documentMongoCursor1 = documents.iterator();
                while (documentMongoCursor1.hasNext()) {
                    System.out.println(documentMongoCursor1.next());
                }

            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
