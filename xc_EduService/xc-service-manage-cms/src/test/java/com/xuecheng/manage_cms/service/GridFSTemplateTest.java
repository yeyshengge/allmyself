package com.xuecheng.manage_cms.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by zps on 2019/12/30 16:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFSTemplateTest {


    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFSBucket gridFSBucket;

    /**
     * 文件存储
     *
     * @throws FileNotFoundException
     */
    @Test
    public void store() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("D:/index_banner.ftl"));
        ObjectId store = gridFsTemplate.store(fis, "index_banner.ftl");
        System.out.println(store);
    }

    /**
     * 文件查询
     */
    @Test
    public void query() throws IOException {
        //先查询该文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is("5e0ade85aa8cac2208ddfdcc")));
        //获取他的objectId
        ObjectId objectId = gridFSFile.getObjectId();
        //开启一个下载流
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(objectId);
        //创建GridFsResource对象，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        //转换为string，便于输出查看
        String content = IOUtils.toString(gridFsResource.getInputStream());
        System.out.println(content);


    }
}
