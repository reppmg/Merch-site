module
    .controller('indexController', function($scope, $http, $location) {
        $scope.insertImage = function (data) {
            if (data === null || data === undefined || data[0] === undefined){
                return 'http://placehold.it/320x150'
            } else {
                try {
                    return '/images/' + data[0];
                } catch (e) {
                    return 'http://placehold.it/320x150'
                }
            }
        };
        $scope.loadCups = function () {
            $http.get("/cup").then(function (data) {
                goods = [];
                data.data.forEach(function (p1, p2, p3) {
                    goods.push(p1.good)
                });
                $scope.goods = goods;
            });
        };
        $scope.loadAll = function () {
            $http.get("/good").then(function (data) {
                $scope.goods = data.data;
            });
        };
        $scope.loadShirts = function () {
            $http.get("/shirt").then(function (data) {
                goods = [];
                data.data.forEach(function (p1, p2, p3) {
                    goods.push(p1.good)
                });
                $scope.goods = goods;
            });
        };

        $http.get("/good").then(function (data) {
            $scope.goods = data.data;
        });
        // $http.get("/cup").then(function (data) {
        //     alert(data);
        //     $scope.cups = data;
        // });
    });