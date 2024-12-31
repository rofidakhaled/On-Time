function requestNotificationPermission() {
    if (!("Notification" in window)) {
        alert("This browser does not support desktop notifications");
        return;
    }

    if (Notification.permission !== "granted") {
        Notification.requestPermission();
    }
}

function showNotification(title, message) {
    if (Notification.permission === "granted") {
        const notification = new Notification(title, {
            body: message,
            icon: '/img/reminder-icon.png'  // You can add an icon later
        });

        notification.onclick = function() {
            window.focus();
            notification.close();
        };
    }
}
