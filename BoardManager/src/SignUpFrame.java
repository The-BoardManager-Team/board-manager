public class SignUpFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SignUpFrame.class.getName());

    // 수정 모드 여부
    private boolean isEditMode = false;
    private int editUserId = -1;
    private String editUsername = "";

    // MainFrame에서 호출되었는지 여부 (회원 추가 모드)
    private boolean isFromMainFrame = false;

    // 회원가입 모드 생성자 (LoginFrame에서 호출)
    public SignUpFrame() {
        initComponents();
        isEditMode = false;
        isFromMainFrame = false;
        setTitle("회원가입");
    }

    // 회원 추가 모드 생성자 (MainFrame에서 호출)
    public SignUpFrame(boolean fromMainFrame) {
        initComponents();
        isEditMode = false;
        isFromMainFrame = fromMainFrame;
        setTitle("회원 추가");
    }

    // 회원수정 모드 생성자
    public SignUpFrame(int userId, String username, String name, String studentId,
                       String gender, String birthDate, String password) {
        initComponents();
        isEditMode = true;
        editUserId = userId;
        editUsername = username;

        // 기존 정보로 필드 채우기
        txtId.setText(username);
        txtId.setEditable(false); // 아이디는 수정 불가
        btnIdCheck.setVisible(false); // 중복 체크 버튼 숨김

        txtName.setText(name);
        txtNo.setText(studentId);

        // 성별 설정
        if ("남".equals(gender)) {
            rbtnMale.setSelected(true);
        } else if ("여".equals(gender)) {
            rbtnFemale.setSelected(true);
        }

        // 생년월일 파싱 (YYYY-MM-DD 형식)
        if (birthDate != null && !birthDate.isEmpty()) {
            String[] dateParts = birthDate.split("-");
            if (dateParts.length == 3) {
                txtYear.setText(dateParts[0]);
                cbnMonth.setSelectedIndex(Integer.parseInt(dateParts[1]) - 1);
                txtDay.setText(dateParts[2]);
            }
        }

        // 비밀번호는 비워둠 (변경하려면 입력)
        txtPw.setText("");
        txtPwCheck.setText("");

        // 버튼 텍스트 변경
        btnSignup.setText("회원 수정");
        setTitle("회원 정보 수정");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGroupGender = new javax.swing.ButtonGroup();
        btnSignup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPw = new javax.swing.JPasswordField();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbnMonth = new javax.swing.JComboBox<>();
        txtDay = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPwCheck = new javax.swing.JPasswordField();
        btnIdCheck = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignUp");

        btnSignup.setText("회원가입");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        jLabel1.setText("아이디");

        jLabel2.setText("비밀번호");

        jLabel3.setText("학번");

        jLabel4.setText("성별");

        rbtnGroupGender.add(rbtnMale);
        rbtnMale.setText("남성");

        rbtnGroupGender.add(rbtnFemale);
        rbtnFemale.setText("여성");

        jLabel5.setText("생년월일");

        jLabel6.setText("이름");

        txtYear.setText("2025");

        jLabel7.setText("년");

        jLabel8.setText("월");

        cbnMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbnMonth.setSelectedIndex(11);

        jLabel9.setText("일");

        jLabel10.setText("비밀번호 확인");

        btnIdCheck.setText("중복 체크");
        btnIdCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdCheckActionPerformed(evt);
            }
        });

        btnCancel.setText("취소");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPwCheck)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rbtnMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFemale))
                    .addComponent(txtNo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIdCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPw, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(btnSignup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIdCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPwCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(cbnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignup)
                    .addComponent(btnCancel))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if (isEditMode) {
            handleEditMember();
        } else {
            handleSignup();
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    /**
     * 회원가입 처리
     */
    private void handleSignup() {
        // 1. 입력값 가져오기
        String username = txtId.getText().trim();
        String password = new String(txtPw.getPassword()).trim();
        String passwordCheck = new String(txtPwCheck.getPassword()).trim();
        String studentId = txtNo.getText().trim();
        String name = txtName.getText().trim();
        String year = txtYear.getText().trim();
        String month = String.valueOf(cbnMonth.getSelectedIndex() + 1);
        String day = txtDay.getText().trim();

        // 2. 필수 입력 검증
        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "아이디, 비밀번호, 이름은 필수 입력 항목입니다.");
            return;
        }

        // 3. 비밀번호 확인
        if (!password.equals(passwordCheck)) {
            javax.swing.JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            return;
        }

        // 4. 성별 가져오기
        String gender = null;
        if (rbtnMale.isSelected()) {
            gender = "남";
        } else if (rbtnFemale.isSelected()) {
            gender = "여";
        }

        // 5. 생년월일 구성
        String birthDate = null;
        if (!year.isEmpty() && !month.isEmpty() && !day.isEmpty()) {
            birthDate = String.format("%s-%02d-%02d", year, Integer.parseInt(month), Integer.parseInt(day));
        }

        // 6. DB에 회원 정보 저장
        insertUser(username, password, studentId, name, gender, birthDate);
    }

    /**
     * 회원 정보 수정 처리
     */
    private void handleEditMember() {
        // 1. 입력값 가져오기
        String password = new String(txtPw.getPassword()).trim();
        String passwordCheck = new String(txtPwCheck.getPassword()).trim();
        String studentId = txtNo.getText().trim();
        String name = txtName.getText().trim();
        String year = txtYear.getText().trim();
        String month = String.valueOf(cbnMonth.getSelectedIndex() + 1);
        String day = txtDay.getText().trim();

        // 2. 필수 입력 검증
        if (name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "이름은 필수 입력 항목입니다.");
            return;
        }

        // 3. 비밀번호 변경 체크 (입력되었을 경우만)
        if (!password.isEmpty() || !passwordCheck.isEmpty()) {
            if (!password.equals(passwordCheck)) {
                javax.swing.JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
                return;
            }
        }

        // 4. 성별 가져오기
        String gender = null;
        if (rbtnMale.isSelected()) {
            gender = "남";
        } else if (rbtnFemale.isSelected()) {
            gender = "여";
        }

        // 5. 생년월일 구성
        String birthDate = null;
        if (!year.isEmpty() && !month.isEmpty() && !day.isEmpty()) {
            birthDate = String.format("%s-%02d-%02d", year, Integer.parseInt(month), Integer.parseInt(day));
        }

        // 6. DB 업데이트
        updateUser(editUserId, password, studentId, name, gender, birthDate);
    }

    /**
     * 회원 정보 DB에 저장
     */
    private void insertUser(String username, String password, String studentId,
                           String name, String gender, String birthDate) {
        String sql = "INSERT INTO users (username, password, student_id, name, gender, birth_date, role) " +
                     "VALUES (?, ?, ?, ?, ?, ?, 'member')";

        try (java.sql.Connection conn = new DBConnection().getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, studentId);
            pstmt.setString(4, name);
            pstmt.setString(5, gender);
            pstmt.setString(6, birthDate);

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                if (isFromMainFrame) {
                    javax.swing.JOptionPane.showMessageDialog(this, "회원이 추가되었습니다!");
                    dispose(); // MainFrame은 그대로 유지
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!");
                    dispose();
                    new LoginFrame().setVisible(true);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.");
            }

        } catch (java.sql.SQLException e) {
            if (e.getErrorCode() == 1062) { // Duplicate entry
                javax.swing.JOptionPane.showMessageDialog(this, "이미 사용 중인 아이디입니다.");
            } else {
                System.err.println("회원가입 중 오류 발생: " + e.getMessage());
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "회원가입 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    /**
     * 회원 정보 DB에서 수정
     */
    private void updateUser(int userId, String password, String studentId,
                           String name, String gender, String birthDate) {
        String sql;
        boolean updatePassword = !password.isEmpty();

        // 비밀번호 변경 여부에 따라 SQL 다르게 구성
        if (updatePassword) {
            sql = "UPDATE users SET password=?, student_id=?, name=?, gender=?, birth_date=? WHERE id=?";
        } else {
            sql = "UPDATE users SET student_id=?, name=?, gender=?, birth_date=? WHERE id=?";
        }

        try (java.sql.Connection conn = new DBConnection().getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int paramIndex = 1;
            if (updatePassword) {
                pstmt.setString(paramIndex++, password);
            }
            pstmt.setString(paramIndex++, studentId);
            pstmt.setString(paramIndex++, name);
            pstmt.setString(paramIndex++, gender);
            pstmt.setString(paramIndex++, birthDate);
            pstmt.setInt(paramIndex, userId);

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "회원 정보가 수정되었습니다!");
                // 회원 수정은 창만 닫고 MainFrame에 그대로 유지
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "회원 정보 수정에 실패했습니다.");
            }

        } catch (java.sql.SQLException e) {
            System.err.println("회원 정보 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "회원 정보 수정 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void btnIdCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdCheckActionPerformed
        String username = txtId.getText().trim();

        if (username.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.");
            return;
        }

        // DB에서 중복 체크
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (java.sql.Connection conn = new DBConnection().getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "이미 사용 중인 아이디입니다.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다!");
                }
            }

        } catch (java.sql.SQLException e) {
            System.err.println("아이디 중복 체크 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "중복 체크 중 오류가 발생했습니다.");
        }
    }//GEN-LAST:event_btnIdCheckActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose(); // 창 닫기

        // LoginFrame에서 호출된 회원가입 모드일 때만 LoginFrame으로 돌아감
        if (!isEditMode && !isFromMainFrame) {
            new LoginFrame().setVisible(true);
        }
        // MainFrame에서 호출되었거나 수정 모드일 때는 그냥 닫기만 (MainFrame 유지)
    }//GEN-LAST:event_btnCancelActionPerformed


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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIdCheck;
    private javax.swing.JButton btnSignup;
    private javax.swing.JComboBox<String> cbnMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.ButtonGroup rbtnGroupGender;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNo;
    private javax.swing.JPasswordField txtPw;
    private javax.swing.JPasswordField txtPwCheck;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
