package real_spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionValidatorBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String definitionName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition bd = beanFactory.getBeanDefinition(definitionName);
            if (bd.getDestroyMethodName() != null && bd.isPrototype()) {
                System.err.println("Bean [" + bd.getBeanClassName() +
                        "] has an useless scale [prototype] with destroy-method [" + bd.getDestroyMethodName() + "]");
            }
        }
    }
}
