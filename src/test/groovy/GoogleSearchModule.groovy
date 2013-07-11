import geb.Module
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: mrugen
 * Date: 10/7/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
class GoogleSearchModule extends Module {
    def buttonValue

    static content ={

        field{$("input",name:"q")}
        button(to:GoogleResultsPage) {
            $("input",value:buttonValue)
        }
    }
}

class GoogleHomePage extends Page {

    // pages can define their location, either absolutely or relative to a base
    static url = "http://google.com/ncr"

    // “at checkers” allow verifying that the browser is at the expected page
    static at = { title == "Google" }

    static content = {
        // include the previously defined module
        search { module GoogleSearchModule, buttonValue: "Google Search" }
    }
}

class GoogleResultsPage extends Page {
    static at = { title.endsWith "Google Search" }
    static content = {
        // reuse our previously defined module
        search { module GoogleSearchModule, buttonValue: "Search" }

        // content definitions can compose and build from other definitions
        results { $("li.g") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("a.l") }
        firstResultLink { resultLink(0) }
    }
}

class WikipediaPage extends Page {
    static at = { title == "no wiki" }
}