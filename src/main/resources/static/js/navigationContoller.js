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
// module.config(function ($locationProvider) {
//     $locationProvider.html5Mode(true);
//     // $locationProvider.hashPrefix('');
// });
module
    .controller('navigationController', function ($scope, $http, $location, sharedProperties) {
        // $locationProvider.html5Mode(false);
        // $locationProvider.hashPrefix('');
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
            // if (!data.data.registered) {
            //     $location.url("/registration.html?id=" + 123687932534);
            // }
            $scope.user = data.data.authenticated;

            sharedProperties.setProperty(data.data.uid);
            $scope.authenticated = "Logged as " + data.data
                    .first_name;
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