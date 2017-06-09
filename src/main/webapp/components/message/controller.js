/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module("webApp");
webApp.controller("messageController",['$scope', '$rootScope', 'messageService', control]);

function control($scope, $rootScope, messageService) {
    $scope.message = {
        'body' : '',
        'sender' : $rootScope.userInfo.username,
        'time' : ''
    };
    $scope.messageList = [];

    var updateMessageList = function (message) {
        $scope.messageList.push(message);
        $scope.$apply();
    };

    messageService.setMessageUpdateCallback(updateMessageList);

    $scope.sendMessage = function () {
        var date = new Date();
        $scope.message.time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        messageService.sendMessage($scope.message);
        $scope.message.body = '';
    }
}