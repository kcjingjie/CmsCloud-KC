import java.util.concurrent.Callable;

class MyCallableA implements Callable<String> {
    public String call() throws Exception {  
        System.out.println("开始执行Callable");  
        String[] ss={"zhangsan","lisi"};  
        long[] num=new long[2];  
        for(int i=0;i<1000000;i++){  
            num[(int)(Math.random()*2)]++;  
        }  
          
        if(num[0]>num[1]){  
            return ss[0];  
        }else if(num[0]<num[1]){  
            throw new Exception("弃权!");  
        }else{  
            return ss[1];  
        }  
    }  
      
}  