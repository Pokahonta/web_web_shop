function setLang(langId) {
    $.get("http://localhost:8091/setLang/" + langId, function(data) {
        location.reload();
    });
}