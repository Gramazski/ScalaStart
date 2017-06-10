/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module('webApp', ["ngRoute"]).config(function ($routeProvider) {
    $routeProvider.when('/',
        {
            templateUrl: 'views/components/home/view.html',
            controller: 'homeController'
        });
    $routeProvider.when('/login',
        {
            templateUrl: 'views/components/login/view.html',
            controller: 'loginController'
        });

    $routeProvider.otherwise({redirectTo: '/'});

}).run(function($rootScope, $location) {
    $rootScope.loggedInUser = false;

    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
        if ($rootScope.loggedInUser === false) {
            if (!((next.templateUrl == "views/components/home/view.html") || (next.templateUrl == "views/components/login/view.html"))) {
                $location.path("/");
            }
        }
        else {
            if (next.templateUrl == "ui/components/login/view.html") {
                $location.path("/");
            }
        }
    });
});