angular
    .module("app", [])
    .controller("home", function($http, $location) {
        var self = this;
        self.logout = function() {
            $http.post('/logout', {}).success(function() {
                self.authenticated = false;
                $location.path("/");
            }).error(function(data) {
                console.log("Logout failed");
                self.authenticated = false;
            });
        };
    });