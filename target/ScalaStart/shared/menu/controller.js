/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module("webApp");
webApp.controller("menuController",['$scope', '$rootScope', '$location', 'logoutService', control]);

function control($scope, $rootScope, $location, logoutService) {
    $scope.logoutUser = function () {
        var promiseObj = logoutService.doLogout();
        promiseObj.then(function(value) {
            $rootScope.loggedInUser = false;
            $location.path('/');
        });
    }
}