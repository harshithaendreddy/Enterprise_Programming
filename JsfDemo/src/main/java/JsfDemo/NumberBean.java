package JsfDemo;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="num", eager=true)//This is used to get or set data from jsf file (xhtml)
//num is the name of the bean
public class NumberBean {
int x;
int y;
int z;
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getZ() {
	return z;
}
public void setZ(int z) {
	this.z = z;
}
public void biggest() {
	if (x > y)
		z = x;
	else 
		z = y;
}



}