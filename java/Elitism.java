import java.util.ArrayList;
import java.util.List;

public class Elitism {
	public static Genetic_algorithm elitism(Genetic_algorithm ga, Load_problem load, List<Integer> x, Particle_swarm para, int gen_num){
		for (int i=0; i<load.elitism; i++) {
			Population pool = ga.elite_pop.get(i).clone();
			pool.init(pool);
			ga.pool.set(x.get(i), pool);
			if (gen_num != 1) {
				List<Double> cr = new ArrayList<Double>(para.cr_para.get(ga.elite_pop.get(i).popnum));
				List<Double> lb = new ArrayList<Double>(para.lb_para.get(ga.elite_pop.get(i).popnum));
				para.cr_para.set(x.get(i), cr);
				para.lb_para.set(x.get(i), lb);
				para.min_distance_pop.set(x.get(i), para.min_distance_pop.get(ga.elite_pop.get(i).popnum));
				para.min_vehinum_pop.set(x.get(i), para.min_vehinum_pop.get(ga.elite_pop.get(i).popnum));
			}
		}
		return ga;
	}
}
