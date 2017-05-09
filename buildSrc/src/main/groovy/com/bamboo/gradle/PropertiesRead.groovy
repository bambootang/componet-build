import org.gradle.api.Project

static findProperty(String propertiesFile, String propertyName) {
    if (propertiesFile != null) {
        java.util.Properties properties = new java.util.Properties()
        InputStream inputStream = new File(propertiesFile).newDataInputStream()
        properties.load(inputStream)
        def propertyValue = properties.getProperty(propertyName)
        return propertyValue == null ? "" : propertyValue
    }
    return "";
}


static verifyProperties(Project project, String propertyName, String property) {
    return findProperty(project.getProjectDir().absolutePath + '/include.properties', propertyName).split(",").contains(property)
}