package com.marvin.bundle.admin.container;

import com.marvin.bundle.admin.AdminBundle;
import com.marvin.component.configuration.ConfigurationInterface;
import com.marvin.component.container.ContainerBuilder;
import com.marvin.component.container.extension.Extension;
import com.marvin.component.container.xml.XMLDefinitionReader;
import com.marvin.component.resource.ResourceService;
import com.marvin.component.resource.loader.ClasspathResourceLoader;
import com.marvin.component.resource.reference.ResourceReference;
import com.marvin.component.xml.XMLReader;
import java.util.Map;

public class AdminExtension  extends Extension {

    @Override
    public void load(Map<String, Object> configs, ContainerBuilder builder) {
        ResourceService service = ResourceService.builder()
                .with(ResourceReference.CLASSPATH, new ClasspathResourceLoader(AdminBundle.class))
                .build();
        XMLReader reader = new XMLDefinitionReader(service, builder);

        reader.read("resources/config/services.xml");
        
        ConfigurationInterface configuration = getConfiguration();
        Map<String, Object> config = processConfiguration(configuration, configs);

    }
}
