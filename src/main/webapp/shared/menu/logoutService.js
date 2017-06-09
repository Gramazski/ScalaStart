/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module('webApp');
webApp.factory('logoutService',['$http', '$q', logout]);

function logout($http, $q) {
    return{
        doLogout: function () {
            var deferred = $q.defer();
            $http({
                method: 'POST',
                url: '/controller?command=LOGOUT',
                headers: {
                    'Content-Type': 'json'
                }
            }).
            then(function(response) {
                    deferred.resolve(response.data);
                },
                function(response) {
                    deferred.reject(response.status);
                });

            return deferred.promise;
        }
    }
}