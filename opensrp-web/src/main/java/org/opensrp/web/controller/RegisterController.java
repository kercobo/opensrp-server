package org.opensrp.web.controller;

import org.opensrp.dto.register.ANC_RegisterDTO;
import org.opensrp.dto.register.ELCORegisterDTO;
import org.opensrp.dto.register.HHRegisterDTO;
import org.opensrp.register.mcare.ANCRegister;
import org.opensrp.register.mcare.ELCORegister;
import org.opensrp.register.mcare.HHRegister;
import org.opensrp.register.mcare.mapper.ANCRegisterMapper;
import org.opensrp.register.mcare.mapper.ELCORegisterMapper;
import org.opensrp.register.mcare.mapper.HHRegisterMapper;
import org.opensrp.register.mcare.service.ANCRegisterService;
import org.opensrp.register.mcare.service.ELCORegisterService;
import org.opensrp.register.mcare.service.HHRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class RegisterController {

	private static final RequestMethod[] GET = null;
	private ELCORegisterService ecRegisterService;
	private HHRegisterService hhRegisterService;
	private ANCRegisterService ancRegisterService;
	private ELCORegisterMapper ecRegisterMapper;
	private HHRegisterMapper hhRegisterMapper;
	private ANCRegisterMapper ancRegisterMapper;
	
	@Autowired
	public RegisterController(ELCORegisterService ecRegisterService,
			HHRegisterService hhRegisterService,
			ELCORegisterMapper ecRegisterMapper,
			HHRegisterMapper hhRegisterMapper,ANCRegisterService ancRegisterService,ANCRegisterMapper ancRegisterMapper) {
		this.ecRegisterService = ecRegisterService;
		this.hhRegisterService = hhRegisterService;
		this.ecRegisterMapper = ecRegisterMapper;
		this.hhRegisterMapper = hhRegisterMapper;
		this.ancRegisterService = ancRegisterService;
		this.ancRegisterMapper = ancRegisterMapper;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registers/hh")
    @ResponseBody
    public ResponseEntity<HHRegisterDTO> hhRegister(@RequestParam("anm-id") String anmIdentifier) {
        HHRegister hhRegister = hhRegisterService.getHHRegisterForProvider(anmIdentifier);
        return new ResponseEntity<>(hhRegisterMapper.mapToDTO(hhRegister), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registers/ec")
    @ResponseBody
    public ResponseEntity<ELCORegisterDTO> ecRegister(@RequestParam("anm-id") String anmIdentifier) {
        ELCORegister ecRegister = ecRegisterService.getELCORegisterForProvider(anmIdentifier);
        return new ResponseEntity<>(ecRegisterMapper.mapToDTO(ecRegister), HttpStatus.OK);
    }

	
	
  /*  private ANCRegisterService ancRegisterService;
    private PNCRegisterService pncRegisterService;
    private ECRegisterService ecRegisterService;
    private ChildRegisterService childRegisterService;
    private FPRegisterService fpRegisterService;
    private ANCRegisterMapper ancRegisterMapper;
    private ECRegisterMapper ecRegisterMapper;
    private ChildRegisterMapper childRegisterMapper;
    private FPRegisterMapper fpRegisterMapper;
    private PNCRegisterMapper pncRegisterMapper;

    @Autowired
    public RegisterController(ANCRegisterService ancRegisterService,
                              PNCRegisterService pncRegisterService,
                              ECRegisterService ecRegisterService,
                              ChildRegisterService childRegisterService,
                              FPRegisterService fpRegisterService,
                              ANCRegisterMapper ancRegisterMapper,
                              ECRegisterMapper ecRegisterMapper,
                              ChildRegisterMapper childRegisterMapper,
                              FPRegisterMapper fpRegisterMapper,
                              PNCRegisterMapper pncRegisterMapper) {
        this.ancRegisterService = ancRegisterService;
        this.ecRegisterService = ecRegisterService;
        this.pncRegisterService = pncRegisterService;
        this.childRegisterService = childRegisterService;
        this.fpRegisterService = fpRegisterService;
        this.ancRegisterMapper = ancRegisterMapper;
        this.ecRegisterMapper = ecRegisterMapper;
        this.childRegisterMapper = childRegisterMapper;
        this.fpRegisterMapper = fpRegisterMapper;
        this.pncRegisterMapper = pn@RequestMapping(method = GET, value = "/registers/ec")
    @ResponseBody
    public ResponseEntity<ECRegisterDTO> ecRegister(@RequestParam("anm-id") String anmIdentifier) {
        ECRegister ecRegister = ecRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ecRegisterMapper.mapToDTO(ecRegister), HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/registers/anc")
    @ResponseBody
    public ResponseEntity<ANCRegisterDTO> ancRegister(@RequestParam("anm-id") String anmIdentifier) {
        ANCRegister ancRegister = ancRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ancRegisterMapper.mapToDTO(ancRegister), HttpStatus.OK);
    }cRegisterMapper;
    }

    @RequestMapping(method = GET, value = "/registers/ec")
    @ResponseBody
    public ResponseEntity<ECRegisterDTO> ecRegister(@RequestParam("anm-id") String anmIdentifier) {
        ECRegister ecRegister = ecRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ecRegisterMapper.mapToDTO(ecRegister), HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/registers/anc")
    @ResponseBody
    public ResponseEntity<ANC_RegisterDTO> ancRegister(@RequestParam("anm-id") String anmIdentifier) {
        ANCRegister ancRegister = ancRegisterService.getANCRegisterForProvider(anmIdentifier);        
        return new ResponseEntity<>(ancRegisterMapper.mapToDTO(ancRegister), HttpStatus.OK);
      
    }
/*
    @RequestMapping(method = GET, value = "/registers/child")
    @ResponseBody
    public ResponseEntity<ChildRegisterDTO> childRegister(@RequestParam("anm-id") String anmIdentifier) {
        ChildRegister childRegister = childRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(childRegisterMapper.mapToDTO(childRegister), HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/registers/fp")
    @ResponseBody
    public ResponseEntity<FPRegisterDTO> fpRegister(@RequestParam("anm-id") String anmIdentifier) {
        FPRegister fpRegister = fpRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(fpRegisterMapper.mapToDTO(fpRegister), HttpStatus.OK);

    }

    @RequestMapping(method = GET, value = "/registers/pnc")
    @ResponseBody
    public ResponseEntity<PNCRegisterDTO> pncRegister(@RequestParam("anm-id") String anmIdentifier) {
        PNCRegister pncRegister = pncRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(pncRegisterMapper.mapToDTO(pncRegister), HttpStatus.OK);
    }*/
}
