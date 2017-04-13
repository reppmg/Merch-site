getGoods();
function getGoods() {
    var goods = JSON.parse(httpGet(document.URL + "goods"))
    for (var i = 0; i < goods.length; i++){
        var good = goods[i];
       alert(good.id)

    }
}
function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    //todo:rework to async
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}