package com.blog.repository.es;

import com.blog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Crete by Marlon
 * Create Date: 2018/3/22
 * Class Describe
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRespositoryData() {
        //清除所有数据
        esBlogRepository.deleteAll();
//        esBlogRepository.save(new EsBlog("大漠孤烟直", "长河落日圆", "春江花月夜"));
//        esBlogRepository.save(new EsBlog("欲穷千里目", "更上一层楼", "黄河远上白云间"));
//        esBlogRepository.save(new EsBlog("一片孤城万仞山", "羌笛胡须怨杨柳", "春风不度玉门关"));
    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() throws Exception {
//        Pageable pageable = new PageRequest(0, 20);
//        String title = "大";
//        String summary = "上";
//        String content = "玉";
//        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
//        assertEquals(page.getTotalElements(), 3);
//        for (EsBlog esBlog : page.getContent()) {
//            System.out.println("--------------------------start");
//            System.out.println(esBlog.toString());
//            System.out.println("--------------------------end");
//        }
    }

    @Test
    public void findByBlogId() throws Exception {

    }

}