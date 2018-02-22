package com.viomi.ssh.jbpm.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jbpm.services.api.DefinitionService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.model.ProcessDefinition;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.query.QueryContext;
import org.kie.spring.factorybeans.RuntimeEnvironmentFactoryBean;
import org.kie.spring.manager.SpringRuntimeManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/processdef")
public class ProcessDefController {
	
	@Autowired
	private RuntimeDataService runtimeDataService;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private DefinitionService definitionService;
	
	@Autowired
	private RuntimeEnvironmentFactoryBean runtimeEnvironmentFactory;
	
	@Autowired
	SpringRuntimeManagerFactoryImpl runtimeManagerFactory = null;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getProcessDef(ModelMap model) {
		
		Collection<ProcessDefinition> processDefinitions = runtimeDataService.getProcesses(new QueryContext(0, 100));

		
		model.addAttribute("processDefinitions", processDefinitions);
		return "processDefList";
 
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getProcessDefinition(@RequestParam String deployment, @RequestParam String id, ModelMap model) {
		
		ProcessDefinition definition = runtimeDataService.getProcessesByDeploymentIdProcessId(deployment, id);
		
		model.addAttribute("processDefinition", definition);
		return "processDef";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newProcessInstance(@RequestParam String deploymentId, @RequestParam String processId,
			@RequestParam Map<String,String> allRequestParams, ModelMap model) {
		Object retry = allRequestParams.get("retry");
		Object retryCount = allRequestParams.get("retrycount");
		Map<String, Object> params = new HashMap<String, Object>(allRequestParams);
		if (retry != null) {
		    params.put("retry", Boolean.parseBoolean(retry.toString()));
		}
		
		if (retryCount != null) {
		    params.put("retrycount", Integer.parseInt(retryCount.toString()));
		}
        
		long processInstanceId = processService.startProcess(deploymentId, processId, params);
		model.addAttribute("processInstanceId", processInstanceId);
		return "newProcessInstance";
 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createProcess(){
	    try
        {
            RuntimeEnvironment environment = (RuntimeEnvironment) runtimeEnvironmentFactory.getObject();
            RuntimeManager runtimeManager = runtimeManagerFactory.newSingletonRuntimeManager(environment);
            RuntimeEngine engine = runtimeManager.getRuntimeEngine(null);
            engine.getKieSession().startProcess("sfsfs");
            
//            KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//            builder.add(ResourceFactory.newClassPathResource("test.bpmn2"), ResourceType.BPMN2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	    return "";
	}
}
