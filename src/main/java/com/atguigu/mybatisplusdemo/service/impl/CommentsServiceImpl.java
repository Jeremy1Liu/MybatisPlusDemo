package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Comments;
import com.atguigu.mybatisplusdemo.service.CommentsService;
import com.atguigu.mybatisplusdemo.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2023-12-01 14:55:32
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

}




