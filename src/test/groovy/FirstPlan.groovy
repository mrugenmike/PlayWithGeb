import geb.Module
import geb.Page
import geb.spock.GebSpec


class FirstPlanModule extends Module {
    static content ={
       orderNowButton{$("input.orderNowPlanButton")}

    }
}

class FreeSimHomePage extends Page  {
    static  at ={title=="O2 | Free Sim | Order free Pay & Go sim cards"}
    static url="http://o2.co.uk/freesim"
}

class FreeSimSpec extends GebSpec {

    def "It should allow to order a sim"() {
        given:
        to FreeSimHomePage

        expect:
        at FreeSimHomePage

        and:
        $("input.orderNowPlanButton").click()
    }
}