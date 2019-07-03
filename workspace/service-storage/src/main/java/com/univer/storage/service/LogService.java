//package com.univer.storage.service;
//
//import com.univer.storage.po.SysLog;
//import io.searchbox.client.JestClient;
//import io.searchbox.client.JestResult;
//import io.searchbox.core.Bulk;
//import io.searchbox.core.Index;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchScroll;
//import io.searchbox.indices.DeleteIndex;
//import io.searchbox.params.Parameters;
////import org.elasticsearch.index.query.BoolQueryBuilder;
////import org.elasticsearch.index.query.QueryBuilders;
////import org.elasticsearch.search.builder.SearchSourceBuilder;
////import org.elasticsearch.search.sort.SortOrder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
///**
// * @descrption:
// * @author: lvgang
// * @date: 2018-10-23 09:52
// **/
//@Service
//public class LogService {
//
//    @Autowired
//    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
//
//    @Autowired
//    private JestClient jestClient;
//
//    /**
//     * 插入单条数据
//     * @param sysLog
//     */
//    public JestResult saveSysLog(SysLog sysLog){
//        sysLog.setCreateTime(new Date());
//        sysLog.setOrderTime(sysLog.getCreateTime().getTime());
//        Index index = new Index.Builder(sysLog)
//                .index(SysLog.INDEX).type(SysLog.TYPE)
//                .build();
//        try {
//            return jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 批量插入数据
//     * @param list
//     */
//    public JestResult saveLogList(List<SysLog> list){
//        try {
//            Bulk.Builder bulk = new Bulk.Builder();
//            for (SysLog sysLog:list){
//                sysLog.setOrderTime(sysLog.getCreateTime().getTime());
//                Index index = new Index.Builder(sysLog)
//                        .index(SysLog.INDEX).type(SysLog.TYPE)
//                        .build();
//                bulk.addAction(index);
//            }
//            return jestClient.execute(bulk.build());
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 根据id删除
//     * @param id
//     * @return
//     */
//    public JestResult deleteById(String id){
//        DeleteIndex index = new DeleteIndex.Builder(SysLog.INDEX).type(SysLog.TYPE)
//                .addCleanApiParameter(id)
//                .build();
//        try {
//            return jestClient.execute(index);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 更新数据
//     * @param sysLog
//     * @return
//     */
//    public JestResult updateLog(SysLog sysLog){
//
//        String id = sysLog.getId();
//        sysLog.setId(null);
//        Index index = new Index.Builder(sysLog)
//                .index(SysLog.INDEX).type(SysLog.TYPE).id(id)
//                .build();
//        try {
//            return jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
////    public JestResult SearchLogById(String id){
////
////        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
////        boolQueryBuilder.must(QueryBuilders.matchQuery("_id",id));
////
////        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
////        String build =  sourceBuilder.query(boolQueryBuilder).toString();
////
////        Search search = new Search.Builder(build)
////                .addIndex(SysLog.INDEX).addType(SysLog.TYPE)
////                .build();
////        try {
////            return jestClient.execute(search);
////        }catch (Exception e){
////            logger.error(e.getMessage());
////        }
////        return null;
////    }
////
////    /**
////     * 滚动查询
////     * @param sysLog
////     * @return
////     */
////    public JestResult searchLogList(SysLog sysLog){
////        Long size = sysLog.getSize();
////        Long page = sysLog.getPage();
////        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
////        //显示的字段
////        String[] includes = {"id","requestUri","requestMethod","serverAddr","classMethod","exceptionInfo","operator","createTime","executeTime","exception"};
////        //不显示的字段
////        String[] excludes = {};
////
////        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
////        String build =  sourceBuilder
////                .query(boolQueryBuilder)
////                .fetchSource(includes,excludes)
////                .sort("orderTime",SortOrder.ASC)
////                .toString();
////
////        Search search = new Search.Builder(build)
////                .addIndex(SysLog.INDEX).addType(SysLog.TYPE)
////                .setParameter(Parameters.SIZE, size)
////                .setParameter(Parameters.SCROLL, "1m")
////                .build();
////
////        try {
////            JestResult jestResult = jestClient.execute(search);
////            String scrollId = jestResult.getJsonObject().get("_scroll_id").getAsString();
////            for(int i=0;i<page;i++){
////                SearchScroll scroll = new SearchScroll.Builder(scrollId,"1m").build();
////                jestResult=jestClient.execute(scroll);
////                scrollId = jestResult.getJsonObject().get("_scroll_id").getAsString();
////            }
////            return jestResult;
////
////        }catch (Exception e){
////            logger.error(e.getMessage());
////        }
////        return null;
////    }
//
//
//
//    public static void main(String[] args){
//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        System.out.print(uuid);
//    }
//
//}
