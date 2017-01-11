package com.wzguo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.wzguo.mongo.pojo.User;
import org.bson.Document;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wzguo.mongo.utils.BsonUtil.toBson;

/**
 * Created by admin on 2017/1/9.
 */
public class MongoTest {

    public void connectMongo() {
        String user = null;
        String pwd = null;
        String authDb = "imooc";
        String host = "localhost";
        int port = 10000;

        // 直接连接
        // MongoCredential credential = MongoCredential.createCredential(user, authDb, pwd.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port));

        MongoIterable<String> dbs = mongoClient.listDatabaseNames();

        MongoCursor<String> mongoCursor = dbs.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }

        MongoDatabase mongoDatabase = mongoClient.getDatabase("imooc");
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("github");

        User usr = new User(123, "joey", 34, "女");
        usr.setBirth(new Date());
        //  usr.setWealth(new BigDecimal(50000006.24));
        usr.setWeight(56.23);

        List<Object> users = new ArrayList<Object>(3);
        users.add(usr);

        try {
            documentMongoCollection.insertMany(MongoTest.toBsons(users));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        FindIterable<Document> documents = documentMongoCollection.find();
        MongoCursor<Document> documentMongoCursor = documents.iterator();

        while (documentMongoCursor.hasNext()) {
            System.out.println(documentMongoCursor.next());
        }
    }

    public static List<Document> toBsons(List<Object> objs)
            throws IllegalArgumentException, SecurityException,
            IllegalAccessException, InvocationTargetException,
            NoSuchFieldException {
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; null != objs && i < objs.size(); i++) {
            documents.add(toBson(objs.get(i)));
        }
        return documents;
    }

    public static void main(String[] args) {
        new MongoTest().connectMongo();
    }
}
