/**
 * Created by gs on 19.04.2017.
 */
webApp.controller("menuController",['$scope', '$rootScope', '$location', 'logoutService', function ($scope, $rootScope, $location, logoutService) {
    $scope.logoutUser = function () {
        var promiseObj = logoutService.doLogout();
        promiseObj.then(function(value) {
            $rootScope.loggedInUser = false;
            $location.path('/');
        });
    }
}]);

