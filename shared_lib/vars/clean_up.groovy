def call(){
    echo "--- Delete apps --->"
    def etAppNames = ["premerge-et-testing-1", "premerge-et-testing-2", "premerge-et-testing-3"]
    def mysqlAppNames = ["premerge-et-testing-1-mysql", "premerge-et-testing-2-mysql", "premerge-et-testing-3-mysql"]
    etAppNames.each { app ->
        openshift.selector("all", [ app : "$app" ]).delete()
    }
    mysqlAppNames.each { app ->
        openshift.selector("all", [ app : "$app" ]).delete()
    }
    def exist1 = openshift.selector("template", "$templateNameofET").exists()
    if (exist1) {
        echo "--- Delete ET template --->"
        openshift.selector("template", "$templateNameofET").delete()
    } //if
    def exist2 = openshift.selector("template", "$templateNameofMysql").exists()
    if (exist2) {
        echo "--- Delete Mysql template --->"
        openshift.selector("template", "$templateNameofMysql").delete()
    }
}
