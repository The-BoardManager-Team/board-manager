import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());

    private String captchaText = "";
    private Random rand = new Random();

    public LoginFrame() {
        initComponents();
        generateCaptcha();
        txtPW.addActionListener(e -> btnLogin.doClick());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSignUp = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        lblCaptchaImage = new javax.swing.JLabel();
        btnCaptchaRefresh = new javax.swing.JButton();
        txtCaptchaInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        btnLogin.setText("로그인");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("아이디");

        jLabel2.setText("비밀번호");

        txtSignUp.setText("회원가입");
        txtSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSignUpMouseClicked(evt);
            }
        });

        btnCaptchaRefresh.setText("새로고침");
        btnCaptchaRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptchaRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSignUp)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCaptchaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCaptchaRefresh))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(24, 24, 24)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSignUp)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCaptchaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaptchaRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String id = txtID.getText().trim();
        String pw = new String(txtPW.getPassword());
        String captchaInput = txtCaptchaInput.getText().trim();

        DBConnection db = new DBConnection();

        // 캡챠 검증
        if (!captchaInput.equalsIgnoreCase(captchaText)) {
            JOptionPane.showMessageDialog(this, "캡챠가 올바르지 않습니다.");
            generateCaptcha();   // 캡챠 다시 생성
            txtCaptchaInput.setText("");  // 입력창 초기화
            return; // 로그인 중단
        }
        
        // 로그인 검증
        if (db.checkLogin(id, pw)) {
            db.loadUserSession(id);
            new MainFrame().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀립니다.");
            generateCaptcha(); // 캡챠 새로 생성 
        }        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSignUpMouseClicked
        dispose(); 
        new SignUpFrame().setVisible(true); // 메인프레임 열기
    }//GEN-LAST:event_txtSignUpMouseClicked

    private void btnCaptchaRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptchaRefreshActionPerformed
        generateCaptcha();
    }//GEN-LAST:event_btnCaptchaRefreshActionPerformed

    //캡챠 텍스트 생성 및 정답 저장
    private void generateCaptcha() {
        // 혼동되는 문자 제외 (0, O, 1, I 제외) 포함시키는 순간 정말 불쾌함 
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder sb = new StringBuilder();

        // 4-6자 랜덤 길이
        int length = 4 + rand.nextInt(3); 

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }

        captchaText = sb.toString();   // 정답 저장
        drawCaptchaImage(captchaText); // 이미지 그리기
        txtCaptchaInput.setText("");   // 입력창 초기화
    }
    
    //캡챠 이미지 생성 (노이즈, 랜덤 폰트/각도 포함)
    private void drawCaptchaImage(String text) {
        int width = 120;
        int height = 40;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        // 배경색 설정 (밝은 회색)
        g.setColor(new Color(240, 240, 240));
        g.fillRect(0, 0, width, height);

        // 텍스트 그리기 (각 문자마다 랜덤 스타일 적용)
        String[] fontNames = {"Arial", "Verdana", "Courier New", "Georgia"};
        int x = 10;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // 랜덤 폰트 선택
            String fontName = fontNames[rand.nextInt(fontNames.length)];
            int fontSize = 22 + rand.nextInt(6); // 22-27 크기
            g.setFont(new Font(fontName, Font.BOLD, fontSize));

            // 랜덤 색상 (어두운 색상)
            int r = rand.nextInt(100); // 0-99
            int gr = rand.nextInt(100);
            int b = rand.nextInt(100);
            g.setColor(new Color(r, gr, b));

            // 랜덤 각도 회전 (-15° ~ +15°)
            double angle = Math.toRadians(-15 + rand.nextInt(31));
            g.rotate(angle, x + 10, 25);
            g.drawString(String.valueOf(c), x, 28);
            g.rotate(-angle, x + 10, 25); // 회전 복원

            x += 18; // 다음 문자 위치
        }

        // 노이즈 라인 추가 (3-5개)
        g.setColor(new Color(150, 150, 150));
        int lineCount = 3 + rand.nextInt(3); // 3-5개
        for (int i = 0; i < lineCount; i++) {
            int x1 = rand.nextInt(width);
            int y1 = rand.nextInt(height);
            int x2 = rand.nextInt(width);
            int y2 = rand.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        // 점 노이즈 추가 (50-80개)
        int dotCount = 50 + rand.nextInt(31); // 50-80개
        for (int i = 0; i < dotCount; i++) {
            int dotX = rand.nextInt(width);
            int dotY = rand.nextInt(height);
            g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            g.fillOval(dotX, dotY, 1, 1);
        }

        g.dispose();
        lblCaptchaImage.setIcon(new ImageIcon(img));
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaptchaRefresh;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCaptchaImage;
    private javax.swing.JTextField txtCaptchaInput;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JLabel txtSignUp;
    // End of variables declaration//GEN-END:variables
}
