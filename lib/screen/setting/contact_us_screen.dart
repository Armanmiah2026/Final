import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:free_vpn/controller/contact_controller.dart';
import 'package:free_vpn/utils/app_colors.dart';

class ContactUsScreen extends StatefulWidget {
  const ContactUsScreen({super.key});

  @override
  State<ContactUsScreen> createState() => _ContactUsScreenState();
}

class _ContactUsScreenState extends State<ContactUsScreen> {
  @override
  void initState() {
    super.initState();
    Get.find<ContactController>().getContactData();
  }

  Widget _contactRow({
    required IconData icon,
    required String label,
    required String value,
  }) {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Icon(icon, size: 22, color: Colors.black87),
        const SizedBox(width: 12),
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                label,
                style: GoogleFonts.poppins(
                  fontWeight: FontWeight.w600,
                  fontSize: 14,
                  color: Colors.black,
                ),
              ),
              const SizedBox(height: 4),
              SelectableText(
                value.isEmpty ? '—' : value,
                style: GoogleFonts.poppins(
                  fontSize: 14,
                  color: Colors.black54,
                ),
              ),
            ],
          ),
        ),
        IconButton(
          icon: const Icon(Icons.copy_rounded, size: 20),
          tooltip: 'Copy',
          onPressed: value.isEmpty
              ? null
              : () {
                  Clipboard.setData(ClipboardData(text: value));
                  Get.snackbar(
                    'Copied',
                    '$label copied to clipboard',
                    snackPosition: SnackPosition.BOTTOM,
                  );
                },
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<ContactController>(
      builder: (controller) {
        final contact = controller.appContactData;

        return Scaffold(
          backgroundColor: Colors.white,
          appBar: AppBar(
            backgroundColor: Colors.white,
            elevation: 0,
            surfaceTintColor: Colors.transparent,
            centerTitle: true,
            leading: IconButton(
              icon: const Icon(Icons.arrow_back, color: Colors.black),
              onPressed: () => Navigator.pop(context),
            ),
            title: Text(
              'Contact Us',
              style: GoogleFonts.poppins(
                color: Colors.black,
                fontSize: 16,
                fontWeight: FontWeight.w600,
              ),
            ),
          ),
          body: controller.isLoading
              ? const Center(
                  child: CircularProgressIndicator(
                    color: AppColors.appPrimaryColor,
                    strokeWidth: 2,
                  ),
                )
              : contact == null
                  ? Center(
                      child: Padding(
                        padding: const EdgeInsets.all(24),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Text(
                              'No contact data available.',
                              style: GoogleFonts.poppins(fontSize: 15),
                              textAlign: TextAlign.center,
                            ),
                            const SizedBox(height: 16),
                            TextButton.icon(
                              onPressed: () => controller.getContactData(),
                              icon: const Icon(Icons.refresh),
                              label: const Text('Retry'),
                            ),
                          ],
                        ),
                      ),
                    )
                  : RefreshIndicator(
                      color: AppColors.appPrimaryColor,
                      onRefresh: () async => controller.getContactData(),
                      child: ListView(
                        physics: const AlwaysScrollableScrollPhysics(),
                        padding: const EdgeInsets.symmetric(
                          horizontal: 20,
                          vertical: 12,
                        ),
                        children: [
                          Text(
                            'Reach us through any of the channels below.',
                            style: GoogleFonts.poppins(
                              color: Colors.black87,
                              fontSize: 14,
                            ),
                          ),
                          const SizedBox(height: 28),
                          _contactRow(
                            icon: Icons.telegram,
                            label: 'Telegram',
                            value: '${contact['telegram_username'] ?? ''}',
                          ),
                          const SizedBox(height: 20),
                          Divider(color: Colors.grey.shade200, height: 1),
                          const SizedBox(height: 20),
                          _contactRow(
                            icon: Icons.chat_rounded,
                            label: 'WhatsApp',
                            value: '${contact['whatsapp_number'] ?? ''}',
                          ),
                          const SizedBox(height: 20),
                          Divider(color: Colors.grey.shade200, height: 1),
                          const SizedBox(height: 20),
                          _contactRow(
                            icon: Icons.email_outlined,
                            label: 'Email',
                            value: '${contact['contact_email'] ?? ''}',
                          ),
                        ],
                      ),
                    ),
        );
      },
    );
  }
}
