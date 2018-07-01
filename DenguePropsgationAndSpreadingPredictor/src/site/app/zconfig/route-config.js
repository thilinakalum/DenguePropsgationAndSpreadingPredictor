(function () {
    //constants
    angular.module("appModule")
            .constant("systemConfig", {
                apiUrl:
                        location.hostname === 'localhost'
                        ? "http://localhost:8080"
                        : location.protocol + "//" + location.hostname + (location.port ? ':' + location.port : '')
            });

    angular.module("appModule")
            .config(function ($routeProvider) {
                $routeProvider

                        .when("/", {
                            redirectTo: "/risk-anlysis"
                        })
                        .when("/risk-anlysis", {
                            templateUrl: "app/dengue/risk-anlysis.html",
                            controller: "riskAnlysisController"
                        })

                        .otherwise({
                            redirectTo: "/"
                        });
            });
}());