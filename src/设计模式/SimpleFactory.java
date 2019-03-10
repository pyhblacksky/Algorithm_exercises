package 设计模式;

/**
 * @Author: pyh
 * @Date: 2019/3/6 20:26
 * @Version 1.0
 * @Function:   简单工厂模式
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if(type == 1){
            return new ConcreteProduct();
        } else if(type == 2){
            return new ConcreteProduct1();
        } else{
            return new ConcreteProduct2();
        }
    }

    //客户端实现
    public static void main(String[] args){
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        //do something
    }
}

//工厂
interface Product{}

class ConcreteProduct implements Product{}
class ConcreteProduct1 implements Product{}
class ConcreteProduct2 implements Product{}


