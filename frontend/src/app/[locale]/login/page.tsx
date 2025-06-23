import { useTranslations } from "next-intl";

export default function LoginPage() {
  const t = useTranslations();
  return (
    <main>
      <h1>{t("login")}</h1>
    </main>
  );
}
