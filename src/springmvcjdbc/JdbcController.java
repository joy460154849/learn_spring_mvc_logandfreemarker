package springmvcjdbc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.ListPage;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	@Autowired
	private JdbcRepository jdbcRepository;
	@RequestMapping("/list")
	public String list(Model model){
		Region r = jdbcRepository.findOne3(1);
		System.out.println(r.toString());
		List<Region> regionList = jdbcRepository.find();
		System.out.println(regionList);
		ListPage<Region> listPage = jdbcRepository.listPage(1, 30);
		model.addAttribute("region",r);
		return "NewFile";
	}
	
	@RequestMapping("/insert")
	public int insert(){
		Region r = new Region();
		r.setPARENT_ID(9999999.0);
		r.setREGION_CODE("999");
		r.setREGION_ID(88888.0);
		r.setREGION_LEVEL(999999.0);
		r.setREGION_NAME("999");
		r.setREGION_NAME_EN("999");
		r.setREGION_ORDER(999.0);
		r.setREGION_SHORTNAME_EN("999");
		int id = jdbcRepository.update(r);
		System.out.println(id);
		return id;
	}
	
	
}
