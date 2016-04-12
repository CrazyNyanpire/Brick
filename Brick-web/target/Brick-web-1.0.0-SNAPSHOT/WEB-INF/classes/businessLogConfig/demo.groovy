package vm.other.businesslog_resources.businessLogConfig

class OrganizationApplicationImpl {

    def context
 
    def save2PersonInfo() {
        "${getPreTemplate()}:创建个人信息,名字为:${context._param0.name}"
    }
    
    def test() {
    	"test"
    }
     
    def getPreTemplate(){
        "${context._user}-"
    }

}