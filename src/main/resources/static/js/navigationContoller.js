var module = angular.module("merch", ['ngRoute']);

module
    .controller('navigationController', function($scope, $http, $location) {
        $scope.logoutText = "LogOut";
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
            $scope.user = data.authenticated;
            $scope.authenticated = "Logged as " + data.data.userAuthentication.details.response[0].first_name;
        }).catch(function() {
            $scope.user = "N/A";
            $scope.authenticated = false;
        });
        $http.get("/good").then(function (data) {
            $scope.goods = data.data;
        });

        $scope.hide = function() {
            if ($scope.authenticated) {
                return "ng-hide"
            }
        }
    });