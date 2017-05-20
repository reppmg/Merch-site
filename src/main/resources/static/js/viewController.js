module
    .controller('viewController', function($scope, $http, $location) {
        var path = $location.absUrl();
        var id = path.substring(path.lastIndexOf("=")+1);
        var string = "/good/"+id;
        $http.get(string.toString()).then(function (good) {
            $scope.good = good.data;
        }).catch(function (e) {
            var good = {"name":"something is wrong"};
            $scope.good = good;
        });

    });