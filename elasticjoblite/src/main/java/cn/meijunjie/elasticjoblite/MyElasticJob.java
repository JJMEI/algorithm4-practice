//package cn.meijunjie.elasticjoblite;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//
//public class MyElasticJob implements SimpleJob{
//    public void execute(ShardingContext shardingContext) {
//        switch (shardingContext.getShardingItem()){
//            case 0:
//                System.out.println("do something by sharding item 0 .....");
//                break;
//            case 1:
//                System.out.println("do something by sharding item 1 .....");
//                break;
//            case 2:
//                System.out.println("do something by sharding item 2 .....");
//                break;
//        }
//    }
//}
