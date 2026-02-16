package gestion_produit_crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // On récupère le chemin absolu du dossier upload
        String reportPath = Paths.get("uploads/produits").toAbsolutePath().toUri().toString();
        
        // On dit à Spring : "Toutes les requêtes commençant par /upload/produits/ 
        // doivent chercher les fichiers dans le dossier physique"
        registry.addResourceHandler("/upload/produits/**")
                .addResourceLocations(reportPath);
    }
}

