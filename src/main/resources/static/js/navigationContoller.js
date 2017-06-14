var module = angular.module("merch", ['ngRoute']);

module.service('sharedProperties', function () {
    var property = 'First';

    return {
        getProperty: function () {
            return property;
        },
        setProperty: function (value) {
            property = value;
        }
    };
});
module
    .controller('navigationController', function ($scope, $http, $location, sharedProperties) {
        $scope.logoutText = "LogOut";
        $scope.logMeOut = function () {
            $http.post('/logout', {}).then(function () {
                $scope.authenticated = false;
                sharedProperties.setProperty(null);
                $location.path("/");
            }).catch(function (data) {
                console.log("Logout failed");
                console.log(data);
                $scope.authenticated = false;
            });
        };
        $http.get("/user").then(function (data) {
            $scope.user = data.data.authenticated;
            $scope.user_id  = data.data.uid;
            sharedProperties.setProperty(data.data.uid);
            $scope.authenticated = "Logged as " + data.data
                    .first_name;
            if (data.data.authenticated == true && data.data.registered == false) {
                location.replace("/registration.html");
            }
        }).catch(function () {
            $scope.user = "N/A";
            $scope.authenticated = false;
        });
        $http.get("/good").then(function (data) {
            $scope.goods = data.data;
        });

        $scope.hide = function () {
            if ($scope.authenticated) {
                return "ng-hide"
            }
        }

    });