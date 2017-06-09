/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module("webApp");
webApp.controller("loginController",['$scope', '$rootScope', '$location', 'loginService', control]);

function control($scope, $rootScope, $location, loginService) {
    $scope.loginUser = function () {
        var promiseObj = loginService.doLogin($scope.username, $scope.password);
        promiseObj.then(function(value) {
            if (value.id == -1){
                $scope.username = "";
                $scope.password = "";
            }
            else {
                $rootScope.userInfo = value;
                $rootScope.loggedInUser = true;
                $location.path('/');
            }
        });
    }
}