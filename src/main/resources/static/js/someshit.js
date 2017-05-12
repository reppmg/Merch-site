angular.module('merch', [])
    .controller('merchController', function($scope, $http, $location) {
        $scope.logoutText = "ЛогАут";
        var self = this;
        $scope.logMeOut = function() {
            $http.post('/logout', {}).then(function() {
                $scope.authenticated = false;
                $location.path("/");
            }).catch(function(data) {
                console.log("Logout failed");
                console.log(data);
                $scope.authenticated = false;
            });
        };
        $http.get("/user").then(function(data) {
            $scope.user = data.userAuthentication.details.name;
            $scope.authenticated = true;
        }).catch(function() {
            $scope.user = "N/A";
            $scope.authenticated = false;
        });
    });