package directoryDeliveryMechanism.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {
	
	@Value("${ldap.url}")
    private String ldapUrl;
    @Value("${ldap.base}")
    private String partitionSuffix;
    @Value("${ldap.user}")
    private String principal;
    @Value("${ldap.password}")
    private String password;


    @Bean
	public LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl(ldapUrl);
		contextSource.setBase(partitionSuffix);
		contextSource.setUserDn(principal);
		contextSource.setPassword(password);
		return contextSource;
	}

	@Bean
	public LdapTemplate ldapTemplate() {
		LdapTemplate template = new LdapTemplate(contextSource());
		template.setIgnorePartialResultException(true);
		return template;
    }
}