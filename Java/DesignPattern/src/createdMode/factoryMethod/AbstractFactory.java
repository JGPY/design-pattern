package createdMode.factoryMethod;

/* 一个基础接口定义了功能，每个实现接口的子类就是产品，然后定义一个工厂接口，
 * 实现了工厂接口的就是工厂，这时候，接口编程的优点就出现了，我们可以新增产品类
 * （只需要实现产品接口），只需要同时新增一个工厂类，客户端就可以轻松调用新产品的代码。
 *　抽象工厂的灵活性就体现在这里，无需改动原有的代码，毕竟对于客户端来说，静态工厂模式
 * 在不改动StaticFactory类的代码时无法新增产品，如果采用了抽象工厂模式，就可以轻松
 * 的新增拓展类。*/

interface produce{ 	
	Fruit get();
}

class FactoryForBanana implements produce{
    @Override
    public Fruit get() {
        return new Banana();
    }
}
class FactoryForOrange implements produce{
    @Override
    public Fruit get() {
        return new Orange();
    }
}
public class AbstractFactory {
	 public Fruit get(String name){
    	Fruit fruit = null;
    	if (name.equals("Banana")) {
    		fruit= new FactoryForBanana().get();
		}else {
			fruit = new FactoryForOrange().get();
		}
    	return fruit;
    }
}