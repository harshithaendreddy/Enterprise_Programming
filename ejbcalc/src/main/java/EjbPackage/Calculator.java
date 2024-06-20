package EjbPackage;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class Calculator implements CalculatorRemote {

    public Calculator() {
        // TODO Auto-generated constructor stub
    }
    public int add(int a,int b) {
    	return a+b;
    }
	@Override
	public int sub(int a, int b) {
		return a-b;
	}
    

}
