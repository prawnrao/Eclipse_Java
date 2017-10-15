package module2;

public class ParticleMain {

	public static void main(String[] args) {
		FallingParticle fp = new FallingParticle(5.2,3.6);
		fp.setH(10);
		double t = fp.getT();
		System.out.println(t);
		double v = fp.getV();
		System.out.println(v);
		double z = fp.getZ();
		System.out.println(z);
		fp.drop(0.5);
		t = fp.getT();
		System.out.println(t);
		v = fp.getV();
		System.out.println(v);
		z = fp.getZ();
		System.out.println(z);
	}

}
