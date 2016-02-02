// ��������� ����� 
package net.thumbtack.tyunkov.lessons.third.figures;

/*
class Point2D {

	int x, y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point2D() {
		x = 20;
		y = 30;
	}

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

	public void moveTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
*/
public class Point3D extends Point2D {

    double z;

    public Point3D() {
        super();
    }

    public Point3D(double x, double y) {
        super(x, y);
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void moveTo(double dX, double dY, double dZ) {
        super.moveTo(dX, dY);
        z += dZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Point3D point3D = (Point3D) o;

        final double EPS = 1.0E-6;
        return Math.abs(point3D.z - z) < EPS;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
/*
public class Point3D {
	
	public static void print(Point2D pt2) {
		System.out.println("pt2.x = " + pt2.getX() +" pt2.y = " + pt2.getY());
	}

	public static void print(Point3D pt3) {
		System.out.println("pt3.x = " + pt3.getX() +" pt3.y = " + pt3.getY()+ " pt3.z = " + pt3.getZ());
	}

	public static void main(String[] params) {
		print(new Point2D(10,20));
		print(new Point3D(10,20,30));
		
		Point3D pt3 = new Point3D(100, 200, 300);
		Point2D p2 = pt3;
		p2.moveTo(300,  400);
		print(pt3);
		
		int vol = new Point3D(10,20,30) {
			int volume() {
				return x * y * z;
			}
		}.volume();
		
		System.out.println(vol);
		
	}
	
}
*/