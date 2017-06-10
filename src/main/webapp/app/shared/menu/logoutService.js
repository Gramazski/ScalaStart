/**
 * Created by gs on 19.04.2017.
 */
webApp.factory('logoutService',['$http', '$q', function ($http, $q) {
    return{
        doLogout: function () {
            var deferred = $q.defer();
            $http({
                method: 'POST',
                url: '/logout',
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
}]);

