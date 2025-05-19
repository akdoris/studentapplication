// Basic form validation
document.addEventListener('DOMContentLoaded', function() {
    const forms = document.querySelectorAll('form');
    
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            let valid = true;
            
            // Check password match on registration form
            if (form.querySelector('#confirm_password')) {
                const password = form.querySelector('#password').value;
                const confirmPassword = form.querySelector('#confirm_password').value;
                
                if (password !== confirmPassword) {
                    alert('Passwords do not match');
                    valid = false;
                }
            }
            
            if (!valid) {
                e.preventDefault();
            }
        });
    });
});