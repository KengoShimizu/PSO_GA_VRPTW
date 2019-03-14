import java.util.ArrayList;
import java.util.List;

public class Particle_swarm {
	List<Double> gb_para = new ArrayList<Double>(); //global beat parameter set (pc, pm)
	List<List<Double>> lb_para = new ArrayList<List<Double>>(); //local beat parameter set ((pc, pm),(pc, pm)...)
	List<List<Double>> cr_para = new ArrayList<List<Double>>(); //current parameter set ((pc, pm),(pc, pm)...)
	List<Integer> min_vehinum_pop = new ArrayList<Integer>(); //insert minimun number of vehicle per pop (index = pop)
	List<Double> min_distance_pop = new ArrayList<Double>(); //insert minimun distance per pop (index = pop)

	public static Particle_swarm parameter_update(Load_problem problem, Particle_swarm para){
		for (int pop=0; pop<para.cr_para.size(); pop++) {
			double lb_cr_pc = para.lb_para.get(pop).get(0) - para.cr_para.get(pop).get(0);
			double lb_cr_pm = para.lb_para.get(pop).get(1) - para.cr_para.get(pop).get(1);
			double gb_cr_pc = para.gb_para.get(0) - para.cr_para.get(pop).get(0);
			double gb_cr_pm = para.gb_para.get(1) - para.cr_para.get(pop).get(1);
			
			double first_term_pc = problem.c1 * Math.random() * lb_cr_pc;
			double second_term_pc = problem.c2 * Math.random() * gb_cr_pc;
			double first_term_pm = problem.c1 * Math.random() * lb_cr_pm;
			double second_term_pm = problem.c2 * Math.random() * gb_cr_pm;
			//update pc
			para.cr_para.get(pop).set(0, para.cr_para.get(pop).get(0) + first_term_pc + second_term_pc);
			//update pm
			para.cr_para.get(pop).set(1, para.cr_para.get(pop).get(1) + first_term_pm + second_term_pm);
		}
		return para;
	}
}
