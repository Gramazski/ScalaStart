/**
 * Created by gs on 19.04.2017.
 */
var webApp = angular.module('webApp');
webApp.factory('messageService',[service]);

function service() {
    var updateCallback;
    var socket = new WebSocket("ws://localhost:8083/chat");

    socket.onmessage = function(event) {
        var incomingMessage = event.data;
        showMessage(incomingMessage);
    };

    function showMessage(message) {
        updateCallback(JSON.parse(message));
    }

    return{
        setMessageUpdateCallback: function (callback) {
            updateCallback = callback;
        },
        sendMessage: function (message) {
            var outMessage = JSON.stringify(message);
            socket.send(outMessage);
        }
    }
}